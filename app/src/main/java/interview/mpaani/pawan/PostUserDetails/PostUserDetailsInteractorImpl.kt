package interview.mpaani.pawan.PostUserDetails

import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson
import interview.mpaani.pawan.Posts.PostDataDO
import interview.mpaani.pawan.utils.AppConstants

class PostUserDetailsInteractorImpl : PostUserDetailsInteractor {

    //Medium priority NON-UI variables goes below.....


    //Least priority variables goes below.....
    private val TAG:String = "PostUserDetailsInteractorImpl".toString().substring(0,23)


    override fun getUserDetails(postDataDO: PostDataDO, userDetailsListener: PostUserDetailsInteractor.UserDetailsListener) {

        Fuel.get(AppConstants.BASE_URL+ AppConstants.usersURL,
                listOf("id" to postDataDO.userId)).responseString { request, response, result ->

            //do something with response
            result.fold({ data ->
                //Lets parse the JSON Array here....
                val postUserDetailsList:List<PostUserDetailsDO> = Gson().fromJson(data.toString().trim() , Array<PostUserDetailsDO>::class.java).toList()

                var userDetailsObject:PostUserDetailsDO ?= null
                if(!postUserDetailsList.isEmpty())//Negative condition....
                    userDetailsObject = postUserDetailsList[0]
                    //May be there can be some Server error & they can give multiple details with same ID, so we will extract the 1st Data Object & display on the UI....
                    //If there is only 1 Data object thyen also the same condition will work perfectly fine....

                userDetailsListener.userDetailsFetchSuccess(userDetailsObject)
            }, { err ->
                //do something with error
                userDetailsListener.userDetailsFetchFailure(-1,USER_DETAILS_ERROR_CODES_ENUM.NO_USER_DETAILS_FOUND)
            })
        }//Fuel.get closes here.....

    }//getUserDetails closes here.....



    override fun getAllComments(postDataDO: PostDataDO, userDetailsListener: PostUserDetailsInteractor.UserDetailsListener) {
        Fuel.get(AppConstants.BASE_URL+ AppConstants.commentsURL,
                listOf("postId" to postDataDO.id)).responseString { request, response, result ->

            //do something with response
            result.fold({ data ->
                //Lets parse the JSON Array here....
                val commentsList:List<CommentsDO> = Gson().fromJson(data.toString().trim() , Array<CommentsDO>::class.java).toList()

                //May be there can be some Server error & they can give multiple details with same ID, so we will extract the 1st Data Object & display on the UI....
                //If there is only 1 Data object thyen also the same condition will work perfectly fine....

                userDetailsListener.commentsFetchSuccess(commentsList.size, commentsList)
            }, { err ->
                //do something with error
                userDetailsListener.commentsFetchFailure(0, USER_DETAILS_ERROR_CODES_ENUM.NO_COMMENTS_FOUND)
            })
        }//Fuel.get closes here.....
    }//getAllComments closes here.....

}//PostUserDetailsInteractorImpl closes here....
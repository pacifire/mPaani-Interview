package interview.mpaani.pawan.PostUserDetails

import interview.mpaani.pawan.Posts.PostDataDO

interface PostUserDetailsInteractor {


    //THis will have all the Data....
    fun getUserDetails(postDataDO:PostDataDO, userDetailsListener: UserDetailsListener)

    fun getAllComments():List<CommentsDO>



    interface UserDetailsListener{

        fun userDetailsFetchSuccess(totalCommentCount:Long, commentsList:List<CommentsDO>, userDetailsDO:PostUserDetailsDO)

        fun userDetailsFetchFailure(errorCode:Int, errorMsg:String)
    }//UserDetailsListener closes here....

}//PostUserDetailsInteractor closes here....
package interview.mpaani.pawan.PostUserDetails

import interview.mpaani.pawan.Posts.PostDataDO

interface PostUserDetailsInteractor {


    //THis will have all the Data....
    fun getUserDetails(postDataDO:PostDataDO, userDetailsListener: UserDetailsListener)

    fun getAllComments(postDataDO:PostDataDO, userDetailsListener: UserDetailsListener)



    interface UserDetailsListener{

        fun userDetailsFetchSuccess(userDetailsDO:PostUserDetailsDO?)

        fun userDetailsFetchFailure(errorCode:Int, errorMsg:String)

        fun commentsFetchSuccess(totalCommentsCount:Int, commentsDataList:List<CommentsDO>)

        fun commentsFetchFailure(errorCode:Int, errorMsg:String)

        fun updateAvatar(url:String)
    }//UserDetailsListener closes here....

}//PostUserDetailsInteractor closes here....
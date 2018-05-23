package interview.mpaani.pawan.PostUserDetails

import interview.mpaani.pawan.Posts.PostDataDO

interface PostUserDetailsInteractor {


    //THis will have all the Data....
    fun getUserDetails(postDataDO:PostDataDO, userDetailsListener: UserDetailsListener)

    fun getAllComments(postDataDO:PostDataDO, userDetailsListener: UserDetailsListener)



    interface UserDetailsListener{

        fun userDetailsFetchSuccess(userDetailsDO:PostUserDetailsDO?)

        fun userDetailsFetchFailure(errorCode:Int, enumErrorCode:USER_DETAILS_ERROR_CODES_ENUM)

        fun commentsFetchSuccess(totalCommentsCount:Int, commentsDataList:List<CommentsDO>)

        fun commentsFetchFailure(errorCode:Int, enumErrorCode:USER_DETAILS_ERROR_CODES_ENUM)

        fun updateAvatar(url:String)
    }//UserDetailsListener closes here....

}//PostUserDetailsInteractor closes here....
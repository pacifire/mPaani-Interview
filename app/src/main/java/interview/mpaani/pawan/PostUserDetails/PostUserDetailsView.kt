package interview.mpaani.pawan.PostUserDetails

import interview.mpaani.pawan.abstracts.BaseView

interface PostUserDetailsView : BaseView {

    fun setUserDetails(userDetailsDO: PostUserDetailsDO?)

    fun setCommentsData(totalCommentsCount:Int)

    fun displayError(errorCode:Int, enumErrorCode:USER_DETAILS_ERROR_CODES_ENUM)
}//PostUserDetailsView closes here....
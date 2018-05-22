package interview.mpaani.pawan.PostUserDetails

import interview.mpaani.pawan.abstracts.BaseView

interface PostUserDetailsView : BaseView {

    fun setUserDetails(userDetailsDO: PostUserDetailsDO?)

    fun setCommentsData(totalCommentsCount:Int)

}//PostUserDetailsView closes here....
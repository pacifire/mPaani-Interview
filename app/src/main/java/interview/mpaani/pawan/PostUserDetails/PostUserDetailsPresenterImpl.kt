package interview.mpaani.pawan.PostUserDetails

import interview.mpaani.pawan.Posts.PostDataDO

class PostUserDetailsPresenterImpl(view:PostUserDetailsView, interactor: PostUserDetailsInteractor) : PostUserDetailsPresenter, PostUserDetailsInteractor.UserDetailsListener {



    //Medium priority NON-UI variables goes below.....
    private var mView:PostUserDetailsView? = null
    private var mInteractor:PostUserDetailsInteractor


    //Least priority variables goes below.....
    private val TAG:String = "PostUserDetailsPresenterImpl".toString().substring(0,23)


    init {
        mView = view
        mInteractor = interactor
    }


    override fun setPostsData(postDataDO: PostDataDO) {
        mInteractor.getUserDetails(postDataDO, this)
    }//setPostsData closes here.....

    override fun onDestroy() {
        mView = null
    }//onDestroy closes here.....


    override fun userDetailsFetchSuccess(totalCommentCount: Long, commentsList: List<CommentsDO>, userDetailsDO: PostUserDetailsDO) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userDetailsFetchFailure(errorCode: Int, errorMsg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}//PostUserDetailsPresenterImpl closes here.....
package interview.mpaani.pawan.PostUserDetails

import android.util.Log
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

        if(mView != null)
            mView!!.showProgress()

        mInteractor.getUserDetails(postDataDO, this)
        mInteractor.getAllComments(postDataDO, this)
    }//setPostsData closes here.....




    override fun userDetailsFetchSuccess(userDetailsDO: PostUserDetailsDO?) {

        if(mView != null) {
            mView!!.closeProgress()

            if(userDetailsDO != null)
                mView!!.setUserDetails(userDetailsDO)
            else
                Log.w(TAG, "User Details POJO is null....")
        }//if(mView != null) closes here....
        else
            Log.w(TAG, "mView is null....")
    }//userDetailsFetchSuccess closes here....

    override fun commentsFetchSuccess(totalCommentsCount: Int, commentsDataList: List<CommentsDO>) {

        if(mView != null)
            mView!!.setCommentsData(totalCommentsCount)
        else
            Log.w(TAG, "mView is null....")
    }//commentsFetchSuccess closes here....

    override fun commentsFetchFailure(errorCode: Int, errorMsg: String) {

    }//commentsFetchFailure closes here.....

    override fun userDetailsFetchFailure(errorCode: Int, errorMsg: String) {

    }//userDetailsFetchFailure closes here.....


    override fun updateAvatar(url: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }//updateAvatar closes here.....


    override fun onDestroy() {
        mView = null
    }//onDestroy closes here.....

}//PostUserDetailsPresenterImpl closes here.....
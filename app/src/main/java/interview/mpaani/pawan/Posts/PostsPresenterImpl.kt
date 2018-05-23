package interview.mpaani.pawan.Posts

import android.util.Log

class PostsPresenterImpl(view:PostsView, interactor:PostsInteractor) : PostsPresenter, PostsInteractor.OnPostLoadListener {

    //Medium priority NON-UI variables goes below.....
    private var postsView:PostsView? = null
    private var postsinteractor:PostsInteractor
    private lateinit var postsLoadedVia: POSTS_LOADED_VIA

    //Least priority variables goes below.....
    private val TAG:String = "PostsPresenterImpl"


    init {
        postsView = view
        postsinteractor = interactor
    }



    override fun postsLoadSuccess(postsData: List<PostDataDO>) {

        dismissProgress()

        if(postsView != null) {

            //The UI should set the ADapter once we recieved data properly.....
            if (!postsData.isEmpty())//-ve condition....
                postsView!!.setPostsAdapter(postsData)//i.e. we will set Adapter only if there is data in the Array....
            else
                postsView!!.noPostsFound(POSTS_ERROR_CODES_ENUM.POSTS_NOT_AVAILIABLE)
        }//if(postsView != null) closes here.....
        else
            Log.w(TAG, "postsView is null")
    }//postsLoadSuccess closes here....





    override fun postsLoadFailure(postErrorCodeEnum:POSTS_ERROR_CODES_ENUM) {
        dismissProgress()

        if(postsView != null) {
            postsView!!.noPostsFound(POSTS_ERROR_CODES_ENUM.POSTS_NOT_AVAILIABLE)
        }//if(postsView != null) closes here....
        else
            Log.w(TAG, "postsView is null")
    }//postsLoadFailure closes here.....




    override fun loadPosts(postsLoadedVia: POSTS_LOADED_VIA) {
        //Check Validations, in any.....
        //Since no Validtions, therefore we will call API & get the data accordingly....

        this.postsLoadedVia = postsLoadedVia

        if(postsView != null) {
            when (postsLoadedVia) {

                POSTS_LOADED_VIA.NORMAL_LOAD -> postsView!!.showProgress()

                POSTS_LOADED_VIA.PULL_TO_REFRESH_LOAD -> postsView!!.showPullProgress()

                else -> Log.w(TAG, "Progress Not visible bcoz view is null....")
            }//when(postsLoadedVia) closes here.....
        }//if(postsView != null) closes here....
        else
            Log.w(TAG, "Progress Not visible bcoz view is null....")



        postsinteractor.getPostsArray(this)
    }//loadPosts closes here.....



    private fun dismissProgress() {
        if(postsView != null) {

            when (postsLoadedVia) {

                POSTS_LOADED_VIA.NORMAL_LOAD -> postsView!!.closeProgress()

                POSTS_LOADED_VIA.PULL_TO_REFRESH_LOAD -> postsView!!.dismissPullProgress()

                else -> Log.w(TAG, "Progress Not visible bcoz view is null....")
            }//when(postsLoadedVia) closes here.....
        }//if(postsView != null) closes here....
    }//dismissProgress closes here.....


    override fun onDestroy() {
        postsView = null
    }//onDestroy closes here.....
}//PostsPresenterImpl closes here.....
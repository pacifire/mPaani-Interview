package interview.mpaani.pawan.Posts

import android.util.Log

class PostsPresenterImpl(view:PostsView, interactor:PostsInteractor) : PostsPresenter, PostsInteractor.OnPostLoadListener {

    //Medium priority NON-UI variables goes below.....
    private var postsView:PostsView? = null
    private var postsinteractor:PostsInteractor

    //Least priority variables goes below.....
    private val TAG:String = "PostsPresenterImpl"


    init {
        postsView = view
        postsinteractor = interactor
    }



    override fun postsLoadSuccess(postsData: List<PostDataDO>) {

        if(postsView != null) {
            postsView!!.closeProgress()

            //The UI should set the ADapter once we recieved data properly.....
            if (!postsData.isEmpty())//-ve condition....
                postsView!!.setPostsAdapter(postsData)//i.e. we will set Adapter only if there is data in the Array....
            else
                postsView!!.noPostsFound("")
        }//if(postsView != null) closes here.....
        else
            Log.w(TAG, "postsView is null")
    }//postsLoadSuccess closes here....


    override fun postsLoadFailure(postFailureMsg: String) {
        if(postsView != null) {
            postsView!!.closeProgress()
        }//if(postsView != null) closes here....
        else
            Log.w(TAG, "postsView is null")
    }//postsLoadFailure closes here.....


    override fun loadPosts() {
        //Check Validations, in any.....
        //Since no Validtions, therefore we will call API & get the data accordingly....

        if(postsView != null)
            postsView!!.showProgress()


        postsinteractor.getPostsArray(this)
    }//loadPosts closes here.....



    override fun onDestroy() {
        postsView = null
    }//onDestroy closes here.....
}//PostsPresenterImpl closes here.....
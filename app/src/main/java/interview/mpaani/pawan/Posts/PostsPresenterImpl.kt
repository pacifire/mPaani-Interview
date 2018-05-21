package interview.mpaani.pawan.Posts

class PostsPresenterImpl(view:PostsView, presenter:PostsPresenter) : PostsPresenter, PostsInteractor.OnPostLoadListener {



    //Medium priority NON-UI variables goes below.....
    private var postsView:PostsView? = null
    private var postsPresenter:PostsPresenter

    //Least priority variables goes below.....
    private val TAG:String = "PostsPresenterImpl"


    init {
        postsView = view
        postsPresenter = presenter
    }



    override fun postsLoadSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }//postsLoadSuccess closes here.....

    override fun postsLoadFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }//postsLoadFailure closes here.....

    override fun onDestroy() {
        postsView = null
    }//onDestroy closes here.....
}//PostsPresenterImpl closes here.....
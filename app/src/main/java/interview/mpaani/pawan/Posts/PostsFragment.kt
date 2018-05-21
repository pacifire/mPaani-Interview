package interview.mpaani.pawan.Posts

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseFragment

/**
 * A placeholder fragment containing a simple view.
 */
class PostsFragment : BaseFragment(), PostsView {

    //Medium priority NON-Ui variables goes below.....
    private lateinit var postsPresenter:PostsPresenterImpl


    //Least priority variables goes below.....
    private val TAG:String = "PostsFragment"



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_main, container, false)
        postsPresenter = PostsPresenterImpl(this, PostsInteractorImpl())
        postsPresenter.loadPosts()

        return view
    }//onCreateView closes here.....


    override fun showProgress() {

    }

    override fun closeProgress() {

    }

    override fun displayError(errorMessage: String, errorCode: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPostsAdapter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun appendPostsToView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onDestroyView() {
        super.onDestroyView()
        postsPresenter.onDestroy()
    }//onDestroyView closes here.....

    override fun onDestroy() {
        super.onDestroy()
        postsPresenter.onDestroy()
    }//onDestroy closes here.....

}//PostsFragment closes here.....

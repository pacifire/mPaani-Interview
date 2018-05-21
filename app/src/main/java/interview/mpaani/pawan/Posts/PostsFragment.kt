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



    //Least priority variables goes below.....
    private val TAG:String = "PostsFragment"



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }//onCreateView closes here.....


    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

}//PostsFragment closes here.....

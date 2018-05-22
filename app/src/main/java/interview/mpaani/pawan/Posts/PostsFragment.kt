package interview.mpaani.pawan.Posts

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

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



    /**
     * This method sets the Adapter on the RecyclerView.
     * ]**/
    override fun setPostsAdapter(postsData: List<PostDataDO>) {
        var linearLayoutManager = LinearLayoutManager(activity!!)
        postsRecyclerV.layoutManager = linearLayoutManager

//        val dividerItemDecoration = DividerItemDecoration(postsRecyclerV.getContext(),
//                linearLayoutManager.getOrientation())
//        postsRecyclerV.addItemDecoration(dividerItemDecoration)
        postsRecyclerV.adapter = PostsAdapter(postsRecyclerV.context, postsData)
    }//setPostsAdapter closes here.....

    override fun appendPostsToView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun noPostsFound(errorMsg: String) {

    }//noPostsFound closes here.....

    override fun onDestroyView() {
        super.onDestroyView()
        postsPresenter.onDestroy()
    }//onDestroyView closes here.....

    override fun onDestroy() {
        super.onDestroy()
        postsPresenter.onDestroy()
    }//onDestroy closes here.....

}//PostsFragment closes here.....

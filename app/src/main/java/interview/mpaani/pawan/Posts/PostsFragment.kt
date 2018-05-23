package interview.mpaani.pawan.Posts

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */
class PostsFragment : BaseFragment(), PostsView, SwipeRefreshLayout.OnRefreshListener {



    //Medium priority NON-Ui variables goes below.....
    private lateinit var postsPresenter:PostsPresenterImpl


    //Least priority variables goes below.....
    private val TAG:String = "PostsFragment"



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_main, container, false)
        postsPresenter = PostsPresenterImpl(this, PostsInteractorImpl())
        postsPresenter.loadPosts(POSTS_LOADED_VIA.NORMAL_LOAD)

        return view
    }//onCreateView closes here.....


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postsRefreshLayout.setOnRefreshListener(this)
    }

    override fun showProgress() {

    }

    override fun closeProgress() {

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


    override fun appendPostsToView() {}

    override fun noPostsFound(postsErrorEnum : POSTS_ERROR_CODES_ENUM) {

        when(postsErrorEnum) {


            POSTS_ERROR_CODES_ENUM.POSTS_NOT_AVAILIABLE -> Snackbar.make(postsRefreshLayout, getString(R.string.noPostsAvailiableErrorMsg), Snackbar.LENGTH_SHORT).show();

        }//when(postsErrorEnum) closes here.....
    }//noPostsFound closes here.....


    override fun onRefresh() {
        //We will call the API Again....
        if(postsPresenter != null)
            postsPresenter.loadPosts(POSTS_LOADED_VIA.PULL_TO_REFRESH_LOAD)
        else
            Log.w(TAG, "Posts Presenter is null, for Pull to Refresh.")
    }//onRefresh closes here.....


    override fun showPullProgress() {
    }

    override fun dismissPullProgress() {
        if(postsRefreshLayout.isRefreshing)
            postsRefreshLayout.isRefreshing = false
    }//dismissPullProgress closes here....




    override fun onDestroyView() {
        super.onDestroyView()
        postsPresenter.onDestroy()
    }//onDestroyView closes here.....

    override fun onDestroy() {
        super.onDestroy()
        postsPresenter.onDestroy()
    }//onDestroy closes here.....





}//PostsFragment closes here.....

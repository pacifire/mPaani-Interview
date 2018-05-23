package interview.mpaani.pawan.Posts

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseFragment
import interview.mpaani.pawan.utils.AppConstants
import kotlinx.android.synthetic.main.custom_progess.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class PostsFragment : BaseFragment(), PostsView, SwipeRefreshLayout.OnRefreshListener {

    //Medium priority NON-Ui variables goes below.....
    private lateinit var postsPresenter:PostsPresenterImpl
    private lateinit var mPostsData:List<PostDataDO>//For onSaveInstanceState.....

    //Least priority variables goes below.....
    private val TAG:String = "PostsFragment"



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_main, container, false)

        postsPresenter = PostsPresenterImpl(this, PostsInteractorImpl())

        return view
    }//onCreateView closes here.....


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postsRefreshLayout.setOnRefreshListener(this)

        if(savedInstanceState == null)
            postsPresenter.loadPosts(POSTS_LOADED_VIA.NORMAL_LOAD)
        else{
            //Set Adapter using the data in the Bundle....
            mPostsData = savedInstanceState.getParcelableArrayList<PostDataDO>(AppConstants.POSTS_EXTRAS_INSTANCE_STATE)
            if(mPostsData == null)
                postsPresenter.loadPosts(POSTS_LOADED_VIA.NORMAL_LOAD)
            else
                setPostsAdapter(mPostsData)//Lets set the Adapter now.....
        }//else closes here.....
    }//onViewCreated closes here....


    override fun showProgress() {
        progressContainer.visibility = View.VISIBLE
    }

    override fun closeProgress() {
        progressContainer.visibility = View.GONE
        postsRecyclerV.visibility = View.VISIBLE
    }


    /**
     * This method sets the Adapter on the RecyclerView.
     * ]**/
    override fun setPostsAdapter(postsData: List<PostDataDO>) {

        mPostsData = postsData

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


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(::mPostsData.isInitialized)
            outState.putParcelableArrayList(AppConstants.POSTS_EXTRAS_INSTANCE_STATE,mPostsData as ArrayList<PostDataDO>)
    }//onSaveInstanceState closes here.....


    override fun onDestroyView() {
        super.onDestroyView()
        postsPresenter.onDestroy()
    }//onDestroyView closes here.....

    override fun onDestroy() {
        super.onDestroy()
        postsPresenter.onDestroy()
    }//onDestroy closes here.....





}//PostsFragment closes here.....

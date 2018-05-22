package interview.mpaani.pawan.PostUserDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import interview.mpaani.pawan.Posts.PostDataDO
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseFragment
import interview.mpaani.pawan.utils.AppConstants

class PostUserDetailsFragment : BaseFragment(), PostUserDetailsView{


    //Medium priority NON-UI variables goes below......
    private lateinit var postUserpresenter:PostUserDetailsPresenterImpl


    //Least priority variables goes below...
    private val TAG:String = "PostUserDetailsFragment"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view =  inflater.inflate(R.layout.fragment_user, container, false)
        postUserpresenter = PostUserDetailsPresenterImpl(this, PostUserDetailsInteractorImpl())
        return view
    }//onCreateView closes here.....


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Check if we got the Arguments or not !!!!
        if(arguments != null) {
            if (arguments!!.containsKey(AppConstants.SELECTED_POST_EXTRAS)) {

                var selectedPostDO = arguments!![AppConstants.SELECTED_POST_EXTRAS] as PostDataDO
                postUserpresenter.setPostsData(selectedPostDO)

            }//if(arguments.containsKey(AppConstants.POSTS_USER_DETAILS_FRAGMENT_BACKSTACK_TAG)) closes here....
            else
                Log.w(TAG, "Arguments does not contain ${AppConstants.SELECTED_POST_EXTRAS}")
        }//if(arguments != null) closes here....
        else
            Log.w(TAG, "Arguments does not contain ${AppConstants.SELECTED_POST_EXTRAS}")


    }//onViewCreated closes here.....


    override fun setUserDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }//setUserDetails closes here.....


    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayError(errorMessage: String, errorCode: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
        postUserpresenter.onDestroy()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        postUserpresenter.onDestroy()
    }
}//PostUserDetailsFragment class closes here.....
package interview.mpaani.pawan.PostUserDetails

import android.os.Bundle
import android.util.Log
import interview.mpaani.pawan.Posts.PostDataDO
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseActivity
import interview.mpaani.pawan.utils.AppConstants
import kotlinx.android.synthetic.main.content_scrolling.*

class PostUserDetailsActivity : BaseActivity(), PostUserDetailsView{



    //Medium priority NON-UI variables goes below......
    private lateinit var postUserpresenter:PostUserDetailsPresenterImpl


    //Least priority variables goes below...
    private val TAG:String = "PostUserDetailsFragment"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        postUserpresenter = PostUserDetailsPresenterImpl(this, PostUserDetailsInteractorImpl())

        if(intent.hasExtra(AppConstants.SELECTED_POST_EXTRAS)){

            var selectedPostDO = intent.getParcelableExtra<PostDataDO>(AppConstants.SELECTED_POST_EXTRAS)
            postUserpresenter.setPostsData(selectedPostDO)

            postTxtV.setText(selectedPostDO.title)
            postTxtV.append("\n\n")
            postTxtV.append(selectedPostDO.body)
        }//if(intent.hasExtra(AppConstants.SELECTED_POST_EXTRAS)) closes here......
        else
            Log.w(TAG, "Intent does not contain ${AppConstants.SELECTED_POST_EXTRAS}")

    }//onCreate closes here....




    override fun setUserDetails(userDetailsDO: PostUserDetailsDO?) {


        ///////////////.............SETTING DATA FROM INTENT.....................\\\\\\\\\\\\\\\\\\
//        if(userDetailsDO != null) {
//            postTxtV.setText(userDetailsDO.)
//        }//if(userDetailsDO != null) closes here.....
//        else
//            Log.w(TAG , "userDetailsDO is null....")
    }//setUserDetails closes here.....


    override fun showProgress() {

    }

    override fun closeProgress() {

    }

    override fun displayError(errorMessage: String, errorCode: String) {

    }

    override fun onDestroy() {
        super.onDestroy()
        postUserpresenter.onDestroy()
    }//onDestroy closes here....

}//PostUserDetailsFragment class closes here.....
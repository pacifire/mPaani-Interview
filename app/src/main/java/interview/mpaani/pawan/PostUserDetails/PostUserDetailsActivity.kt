package interview.mpaani.pawan.PostUserDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import interview.mpaani.pawan.Posts.PostDataDO
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseActivity
import interview.mpaani.pawan.utils.AppConstants
import kotlinx.android.synthetic.main.activity_user_details.*
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.single_row_posts.*

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

            postsTitleTxtV.setText(selectedPostDO.title)
            postsDescTxtV.setText(selectedPostDO.body)
        }//if(intent.hasExtra(AppConstants.SELECTED_POST_EXTRAS)) closes here......
        else
            Log.w(TAG, "Intent does not contain ${AppConstants.SELECTED_POST_EXTRAS}")




        //////////...............SINCE WE ARE REUSING THE LAYOUT, THEREFORE EDITING THE UI DYNAMICALLY BELOW...................\\\\\\\\\\\\\\\\\\\\
        arrowRtImgV.visibility = View.GONE
        var postCardparams:FrameLayout.LayoutParams = postsCardContainer.layoutParams as FrameLayout.LayoutParams
        postCardparams.topMargin = resources.getDimensionPixelSize(R.dimen.userDetailsFABTopMargin)
        postsCardContainer.layoutParams = postCardparams
    }//onCreate closes here....




    override fun setUserDetails(userDetailsDO: PostUserDetailsDO?) {


        ///////////////.............SETTING DATA FROM INTENT.....................\\\\\\\\\\\\\\\\\\
//        if(userDetailsDO != null) {
//            postTxtV.setText(userDetailsDO.)
//        }//if(userDetailsDO != null) closes here.....
//        else
//            Log.w(TAG , "userDetailsDO is null....")
    }//setUserDetails closes here.....


    override fun setCommentsData(totalCommentsCount: Int) {

        if(totalCommentsCount > 0) {
            commentsCountContainer.visibility = View.VISIBLE
            commentsCountTxtV.setText(totalCommentsCount.toString().trim())
            commentsCountTxtV.bringToFront()
        }//if(totalCommentsCount > 0) closes here.....
        else{
            commentsCountContainer.visibility = View.GONE
        }//else closes here....

    }//setCommentsData closes here.....


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
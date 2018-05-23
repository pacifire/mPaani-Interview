package interview.mpaani.pawan.PostUserDetails

import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import interview.mpaani.pawan.Posts.PostDataDO
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseActivity
import interview.mpaani.pawan.utils.AppConstants
import interview.mpaani.pawan.utils.GlideApp
import kotlinx.android.synthetic.main.activity_user_details.*
import kotlinx.android.synthetic.main.content_userdata.*
import kotlinx.android.synthetic.main.single_row_posts.*

class PostUserDetailsActivity : BaseActivity(), PostUserDetailsView {

    //Medium priority NON-UI variables goes below......
    private lateinit var postUserpresenter: PostUserDetailsPresenterImpl
    private var mUserDetailsDO:PostUserDetailsDO? = null//For onSavedInstanceState.....
    private var mTotalCommentsCount:Int = 0//For saved Instance state lets assume there are no Comments on each post....
    private lateinit var mSelectedPostDO:PostDataDO//For onSavedInstanceState.....


    //Least priority variables goes below...
    private val TAG: String = "PostUserDetailsFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        ////....Handling the Device rotation......
        if(savedInstanceState == null) {


            postUserpresenter = PostUserDetailsPresenterImpl(this, PostUserDetailsInteractorImpl())


            ///////////////.......SETTING DATA FROM INTENT................\\\\\\\\\\\\\\\\\\
            if (intent.hasExtra(AppConstants.SELECTED_POST_EXTRAS)) {

                mSelectedPostDO = intent.getParcelableExtra<PostDataDO>(AppConstants.SELECTED_POST_EXTRAS)
                postUserpresenter.setPostsData(mSelectedPostDO)

                setSelectedPostTitleBody()

            }//if(intent.hasExtra(AppConstants.SELECTED_POST_EXTRAS)) closes here......
            else
                Log.w(TAG, "Intent does not contain ${AppConstants.SELECTED_POST_EXTRAS}")
        }//if(savedInstanceState == null) closes here.....
        else{
            //Setting data from the savedInstanceState....

            if(savedInstanceState.containsKey(AppConstants.COMMENTS_COUNT_EXTRAS_INSTANCE_STATE)) {
                mTotalCommentsCount = savedInstanceState.getInt(AppConstants.COMMENTS_COUNT_EXTRAS_INSTANCE_STATE, 0)
                setCommentsData(mTotalCommentsCount)
            }


            if(savedInstanceState.containsKey(AppConstants.USER_DETAILS_EXTAS_INSTANCE_STATE)) {
                mUserDetailsDO = savedInstanceState.getParcelable(AppConstants.USER_DETAILS_EXTAS_INSTANCE_STATE)
                setUserDetails(mUserDetailsDO)
            }


            if(savedInstanceState.containsKey(AppConstants.SELECTED_POST_EXTA_INSTANCE_STATE)) {
                mSelectedPostDO = savedInstanceState.getParcelable(AppConstants.SELECTED_POST_EXTA_INSTANCE_STATE)
                setSelectedPostTitleBody()
            }

        }//else closes here.....


        //////////...............SINCE WE ARE REUSING THE LAYOUT, THEREFORE EDITING THE UI DYNAMICALLY BELOW...................\\\\\\\\\\\\\\\\\\\\
        arrowRtImgV.visibility = View.GONE
        var postCardparams: FrameLayout.LayoutParams = postsCardContainer.layoutParams as FrameLayout.LayoutParams
        postCardparams.topMargin = resources.getDimensionPixelSize(R.dimen.userDetailsFABTopMargin)
        postsCardContainer.layoutParams = postCardparams
    }//onCreate closes here....


    private fun setSelectedPostTitleBody() {
        postsTitleTxtV.setText(mSelectedPostDO.title)
        postsDescTxtV.setText(mSelectedPostDO.body)
    }//setSelectedPostTitleBody closes here....


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {

            android.R.id.home -> {
                onBackPressed()
                return true
            }

            else ->
                return super.onOptionsItemSelected(item)
        }//when(item!!.itemId) closes here....
    }//onOptionsItemSelected closes here.....


    override fun setUserDetails(userDetailsDO: PostUserDetailsDO?) {
        mUserDetailsDO = userDetailsDO

        if (userDetailsDO != null) {
            toolbar_layout.title = userDetailsDO.userName
            toolbar.title = userDetailsDO.userName
            setTitle(userDetailsDO.userName)
            userFullNameTxtV.setText(userDetailsDO.name)
            toolbarTitle.setText(userDetailsDO.name.toUpperCase())

            //Setting the Avatar now....
            GlideApp.with(this)
                    .load(AppConstants.AVATAR_BASE_URL + AppConstants.AVATAR_SIZE + "/" + userDetailsDO.email)
                    .into(userAvatarImgV)

        }//if(userDetailsDO != null) closes here.....
        else
            Log.w(TAG, "userDetailsDO is null....")
    }//setUserDetails closes here.....


    override fun setCommentsData(totalCommentsCount: Int) {
            this.mTotalCommentsCount = totalCommentsCount


        if (totalCommentsCount > 0) {
            commentsCountContainer.visibility = View.VISIBLE
            commentsCountTxtV.setText(totalCommentsCount.toString().trim())
            commentsCountTxtV.bringToFront()
        }//if(totalCommentsCount > 0) closes here.....
        else {
            commentsCountContainer.visibility = View.GONE
        }//else closes here....

    }//setCommentsData closes here.....


    override fun showProgress() {

    }

    override fun closeProgress() {

    }

    override fun displayError(errorCode: Int, enumErrorCode: USER_DETAILS_ERROR_CODES_ENUM) {

        when (enumErrorCode) {
            USER_DETAILS_ERROR_CODES_ENUM.NO_USER_DETAILS_FOUND -> Snackbar.make(userDetailsParentContainer, getString(R.string.noUserDetailsAvailErrorMsg), Snackbar.LENGTH_SHORT).show()

            USER_DETAILS_ERROR_CODES_ENUM.NO_COMMENTS_FOUND -> Snackbar.make(userDetailsParentContainer, getString(R.string.noCommentsAvailErrorMsg), Snackbar.LENGTH_SHORT).show()

        }//when(enumErrorCode) closes here....
    }//displayError closes here....


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        if(outState != null) {
            outState.putInt(AppConstants.COMMENTS_COUNT_EXTRAS_INSTANCE_STATE, mTotalCommentsCount)

            if(mUserDetailsDO != null)
                outState.putParcelable(AppConstants.USER_DETAILS_EXTAS_INSTANCE_STATE, mUserDetailsDO)

            if(mSelectedPostDO != null)
                outState.putParcelable(AppConstants.SELECTED_POST_EXTA_INSTANCE_STATE, mSelectedPostDO)

        }//if(outState != null) closes here....
        else
            Log.w(TAG, "outState is null....")
    }//onSaveInstanceState closes here.....



    override fun onDestroy() {
        super.onDestroy()
        postUserpresenter.onDestroy()
    }//onDestroy closes here....

}//PostUserDetailsFragment class closes here.....
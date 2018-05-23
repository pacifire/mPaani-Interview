package interview.mpaani.pawan.MainActivity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import interview.mpaani.pawan.Posts.PostsFragment
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseActivity
import interview.mpaani.pawan.utils.AppConstants

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainActivityView {


    //Medium priority NON-UI variables goes below......
    private lateinit var presenter: MainActivityPresenterImpl


    //Least priority varaiables goes below.....
    private val TAG: String = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        initializePosts()



        presenter = MainActivityPresenterImpl(this, MainActivityInteractorImpl())
    }//onCreate closes here.....



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){

            android.R.id.home -> {
                onBackPressed()
                return true
            }

            else ->
                return super.onOptionsItemSelected(item)
        }//when(item!!.itemId) closes here....
    }//onOptionsItemSelected closes here.....

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initializePosts() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, PostsFragment(), AppConstants.POSTS_FRAGMENT_BACKSTACK_TAG)
                .addToBackStack(AppConstants.POSTS_FRAGMENT_BACKSTACK_TAG)
                .commit()
    }//initializePosts closes here....

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }//onDestroy closes here....


    override fun onBackPressed() {
        super.onBackPressed()

        if(supportFragmentManager.backStackEntryCount > 0){
            //There are Fragments in the BackStack....
            supportFragmentManager.popBackStackImmediate()
        }//if(supportFragmentManager.backStackEntryCount > 0) closes here....
        else
            super.onBackPressed()
     }//onBackPressed closes here....
    }//MainActivity class closes here.....

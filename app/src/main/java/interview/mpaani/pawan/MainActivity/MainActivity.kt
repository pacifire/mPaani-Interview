package interview.mpaani.pawan.MainActivity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import interview.mpaani.pawan.Posts.PostsFragment
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseActivity
import interview.mpaani.pawan.utils.AppConstants

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainActivityView {



    //Medium priority NON-UI variables goes below......
    private lateinit var presenter:MainActivityPresenterImpl



    //Least priority varaiables goes below.....
    private val TAG:String = "MainActivity"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        presenter = MainActivityPresenterImpl(this, MainActivityInteractorImpl())

        initializePosts()
    }//onCreate closes here.....

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }//onCreateOptionsMenu closes here.....

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }//onOptionsItemSelected closes here.....



    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayError(errorMessage: String, errorCode: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initializePosts() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, PostsFragment(), AppConstants.POSTS_FRAGMENT_BACKSTACK_TAG)
                .addToBackStack(AppConstants.POSTS_FRAGMENT_BACKSTACK_TAG)
                .commit()
    }//initializePosts closes here....

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }//onDestroy closes here....
}//MainActivity class closes here.....

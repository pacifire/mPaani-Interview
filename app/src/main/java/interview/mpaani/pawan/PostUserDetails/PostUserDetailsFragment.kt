package interview.mpaani.pawan.PostUserDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import interview.mpaani.pawan.R
import interview.mpaani.pawan.abstracts.BaseFragment

class PostUserDetailsFragment : BaseFragment(), PostUserDetailsView{


    //Medium priority NON-UI variables goes below......



    //Least priority variables goes below...
    private val TAG:String = "PostUserDetailsFragment"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view =  inflater.inflate(R.layout.fragment_user, container, false)

        var postUserpresenter = PostUserDetailsPresenterImpl(this, PostUserDetailsInteractorImpl())
//        postUserpresenter.setUserID()

        return view
    }//onCreateView closes here.....


    override fun getUserDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayError(errorMessage: String, errorCode: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}//PostUserDetailsFragment class closes here.....
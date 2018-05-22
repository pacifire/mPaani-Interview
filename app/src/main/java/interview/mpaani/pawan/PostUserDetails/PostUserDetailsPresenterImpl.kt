package interview.mpaani.pawan.PostUserDetails

import android.util.Log

class PostUserDetailsPresenterImpl(view:PostUserDetailsView, interactor: PostUserDetailsInteractor) : PostUserDetailsPresenter {

    //Medium priority NON-UI variables goes below.....



    //Least priority variables goes below.....
    private val TAG:String = "PostUserDetailsPresenterImpl".toString().substring(0,23)

    override fun setUserID(userId: Long) {
        //We will get the USER ID here, lets call the data using interactor & set the data accordingly....
        Log.d(TAG, "Pawan chk USer ID from Parcelize is as Follows: $userId")

    }//setUserID closes here....

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}//PostUserDetailsPresenterImpl closes here.....
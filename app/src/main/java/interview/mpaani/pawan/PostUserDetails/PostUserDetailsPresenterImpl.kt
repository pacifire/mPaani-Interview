package interview.mpaani.pawan.PostUserDetails

class PostUserDetailsPresenterImpl(view:PostUserDetailsView, interactor: PostUserDetailsInteractor) : PostUserDetailsPresenter {

    //Medium priority NON-UI variables goes below.....



    //Least priority variables goes below.....
    private val TAG:String = "PostUserDetailsPresenterImpl"

    override fun setUserID(userId: Long) {
        //We will get the USER ID here, lets call the data using interactor & set the data accordingly....


    }//setUserID closes here....

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}//PostUserDetailsPresenterImpl closes here.....
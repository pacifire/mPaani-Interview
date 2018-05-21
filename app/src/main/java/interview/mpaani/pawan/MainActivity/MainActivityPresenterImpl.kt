package interview.mpaani.pawan.MainActivity

import interview.mpaani.pawan.R

class MainActivityPresenterImpl(view:MainActivityView, interactor:MainActivityInteractor) : MainActivityPresenter, MainActivityInteractor.OnPostLoadFinishListener {



    //Medium priority NOn-Ui variables goes below.....
    private var mainView:MainActivityView? = null//Since we dont want any view to take unnessecary Menory....
    private var mainInteractor:MainActivityInteractor


    //Least priority variables goes below.....
    private val TAG:String = "MainActivityPresenterImpl"



    init {
        mainView = view
        mainInteractor = interactor
    }




    override fun postLoadSuccess(successMsg: String, successCode: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postLoadFailure(failureMsg: String, failureCode: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun activityInitialized() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onDestroy() {
        mainView = null//Removing memory after usage.....
    }//onDestroy closes here......
}//MainActivityPresenterImpl closes here.....
package interview.mpaani.pawan.MainActivity

interface MainActivityInteractor {

    interface OnPostLoadFinishListener{

        fun postLoadSuccess(successMsg:String, successCode:String)

        fun postLoadFailure(failureMsg: String, failureCode:String)
    }//OnPostLoadFinishListener closes here....

}//MainActivityInteractor closes here....
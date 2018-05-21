package interview.mpaani.pawan.abstracts

interface BaseView {

    fun showProgress()

    fun closeProgress()

    fun displayError(errorMessage:String, errorCode:String)

}//BaseView closes here.....
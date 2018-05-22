package interview.mpaani.pawan.Posts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PostDataDO(var userId:Long, var id:Long,
                 var title:String, var body:String) : Parcelable {

//    var userId:Long? = null//Dont trust Backend Dev :(P)
//    var id:Long? = null//Dont trust Backend Dev :(P) (This is the ID of the post)
//    var title:String? = null//This is the title of the post.
//    var body:String? = null//This is the Body of the post.

}//PostDataDO closes here....
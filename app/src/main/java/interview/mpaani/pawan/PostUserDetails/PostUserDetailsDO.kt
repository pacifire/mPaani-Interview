package interview.mpaani.pawan.PostUserDetails

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PostUserDetailsDO(val id:Long, val name:String, val userName:String, val email:String, val userAddress:AddressDO,
                        val userPhoneNumber:String, val userWebsite:String, val userCompany:CompanyDO) : Parcelable {
}//PostUserDetailsDO closes here.....
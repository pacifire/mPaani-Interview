package interview.mpaani.pawan.PostUserDetails

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PostUserDetailsDO(val id:Long, val userFullName:String, val userName:String, val userEmail:String, val userAddress:AddressDO,
                        val userPhoneNumber:String, val userWebsite:String, val userCompany:CompanyDO) : Parcelable {
}//PostUserDetailsDO closes here.....
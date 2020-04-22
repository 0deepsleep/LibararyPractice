package dasdsa.sdn.libararypractice

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun setupEvents() {

        callBtn.setOnClickListener {
            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    // 사용자가 권한을 승인해준 상태
                    val uri = Uri.parse("tel:01063313939")
                    val myIntent = Intent(Intent.ACTION_CALL,uri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    // 사용자가 권한 승인을 거부한 상태
                    Toast.makeText(mContext,"권한 허용 필요",Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("설정 > 권한에서 권한을 바꿔주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()



        }

    }

    override fun setValue() {
        Glide.with(mContext).load("https://pbs.twimg.com/profile_images/1175388672281075712/hJq4CGkQ_400x400.jpg").into(profileImg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValue()
        setupEvents()
    }
}

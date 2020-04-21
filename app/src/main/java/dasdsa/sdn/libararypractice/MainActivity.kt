package dasdsa.sdn.libararypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun setupEvents() {

    }

    override fun setValue() {
        Glide.with(mContext).load("https://pbs.twimg.com/profile_images/1175388672281075712/hJq4CGkQ_400x400.jpg").into(profileImg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

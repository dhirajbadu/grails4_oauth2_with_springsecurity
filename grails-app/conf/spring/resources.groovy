import com.session.UserPasswordEncoderListener
import com.session.CustomUserDetailsService

beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    userDetailsService(CustomUserDetailsService)
}

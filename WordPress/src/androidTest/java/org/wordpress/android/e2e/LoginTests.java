package org.wordpress.android.e2e;
import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wordpress.android.e2e.flows.LoginFlow;
import org.wordpress.android.support.BaseTest;
//import org.junit.Rule;
//import org.wordpress.android.ui.accounts.LoginMagicLinkInterceptActivity;

import static org.wordpress.android.BuildConfig.E2E_SELF_HOSTED_USER_PASSWORD;
import static org.wordpress.android.BuildConfig.E2E_SELF_HOSTED_USER_SITE_ADDRESS;
import static org.wordpress.android.BuildConfig.E2E_SELF_HOSTED_USER_USERNAME;
import static org.wordpress.android.BuildConfig.E2E_WP_COM_USER_PASSWORD;
import static org.wordpress.android.BuildConfig.E2E_WP_COM_USER_SITE_ADDRESS;
import static org.wordpress.android.BuildConfig.E2E_WP_COM_USER_USERNAME;

@RunWith(AndroidJUnit4.class)
public class LoginTests extends BaseTest {
//    @Rule
//    public ActivityTestRule<LoginMagicLinkInterceptActivity> mMagicLinkActivityTestRule =
//            new ActivityTestRule<>(LoginMagicLinkInterceptActivity.class);

    @Before
    public void setUp() {
        logoutIfNecessary();
    }

    @Test
    public void loginWithEmailPassword() {
        new LoginFlow().chooseLogin()
                 .enterEmailAddress()
                 .enterPassword()
                 .confirmLogin();
    }

    @Test
    public void loginWithSiteAddress() {
        new LoginFlow().chooseLogin()
                 .chooseAndEnterSiteAddress(E2E_WP_COM_USER_SITE_ADDRESS)
                 .enterUsernameAndPassword(E2E_WP_COM_USER_USERNAME, E2E_WP_COM_USER_PASSWORD)
                 .confirmLogin();
    }

//    Disabled temporarily, see: https://github.com/wordpress-mobile/WordPress-Android/pull/11283
//    @Test
//    public void loginWithMagicLink() {
//        new LoginFlow().chooseLogin()
//                 .enterEmailAddress()
//                 .chooseMagicLink(mMagicLinkActivityTestRule)
//                 .confirmLogin();
//    }

    @Test
    public void loginWithSelfHostedAccount() {
        new LoginFlow().chooseLogin()
                .chooseAndEnterSiteAddress(E2E_SELF_HOSTED_USER_SITE_ADDRESS)
                .enterUsernameAndPassword(E2E_SELF_HOSTED_USER_USERNAME, E2E_SELF_HOSTED_USER_PASSWORD)
                .confirmLogin();
    }

    @After
    public void tearDown() {
        logoutIfNecessary();
    }
}

package Common;

public class Attributes {
    public static class Login {
        public static final String userName = "//input[@id='email']";
        public static final String passWord  = "//input[@id='password']";
        public static final String loginBtn  = "//button[@data-test-id='cs-email-login']";
        public static final String stackVisibility = "//div[@data-test-id='cs-page-title']";
    }

    public static class stack {
        public static final String newStackBtn      = "//button[@data-test-id='cs-add-stack']";
        public static final String createNewStack   = "//div[@data-test-id='cs-add-stack-create-new']";
        public static final String stackName        = "//input[@name='name']";
        public static final String description      = "//textarea[@name='description']";
        public static final String createStackBtn   = "//button[@data-test-id='cs-create-stack']";
        public static final String successToastMsg  = "//div[@data-test-id='cs-notification-text']";
        public static final String dashBoard        = "//div[@data-test-id='cs-dashboard-title']";
    }

    public static class ContentType {
        public static final String contentType      = "//a[@data-test-id='cs-stack-content-modals']";
        public static final String newContentType   = "//button[@aria-label='Create New Content Type']";
        public static final String createNew        = "//div[@data-test-id='cs-cb-new-ct-child']";
        public static final String contentTypeName  = "//input[@name='name']";
        public static final String uID              = "//input[@name='uid']";
        public static final String description      = "//textarea[@name='description']";
        public static final String saveProceed      = "//button[@aria-label='Save and Proceed']";
    }
}
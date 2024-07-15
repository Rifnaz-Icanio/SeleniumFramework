package PageManager;

import Pages.ContentType;
import Pages.Login;
import Pages.Stack;
public class PageObjectManager
{
    private Login loginUser;
    public Login loginUser()
    {
        return(loginUser ==null)? loginUser = new Login() : loginUser;
    }

    private Stack stackTest;
    public Stack stackView()
    {
        return(stackTest ==null)? stackTest = new Stack() : stackTest;
    }

    private ContentType contentTypeTest;
    public ContentType contentView()
    {
        return(contentTypeTest ==null)? contentTypeTest = new ContentType() : contentTypeTest;
    }
}

package Stack;

public class Browser {

    private ArrayStack currStack;
    private ArrayStack backStack;

    public Browser() {
        currStack = new ArrayStack();
        backStack = new ArrayStack();
    }

    public void openNewPage(String s) {
        currStack.push(s);
    }

    public Object closePage() {
        backStack = new ArrayStack();
        return currStack.pop();
    }

    public Object pageForward() {
        if (backStack.empty()) return "No more page stored.";
        Object page = backStack.pop();
        currStack.push(page);
        return page;
    }

    public Object pageBack() {
        if (currStack.empty()) return "No more page before.";
        Object page = currStack.pop();
        backStack.push(page);
        return page;
    }

}

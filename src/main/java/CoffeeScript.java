import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.io.Resources;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

public class CoffeeScript {

    private final ScriptEngine scriptEngine;

    public CoffeeScript() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        loadScript("coffee-script.js");
        loadScript("cswrapper.js");
    }


    private void loadScript(String someJavascriptFile) {
        evalScript(loadFile(someJavascriptFile));
    }

    private void evalScript(String jsCode) {
        try {
            scriptEngine.eval(jsCode);
        } catch (ScriptException se) {
            System.err.println(se);
        }
    }

    private String loadFile(String resourceName) {
        try {
            return Resources.toString(Resources.getResource(resourceName), Charsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object execute(String coffeescriptcode) {
        try {
            return scriptEngine.eval("coffee('" + coffeescriptcode + "');");
        } catch (ScriptException se) {
            System.err.println(se);
            return null;
        }
    }
}

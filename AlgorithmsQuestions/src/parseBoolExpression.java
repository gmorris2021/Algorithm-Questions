
public class parseBoolExpression {
    public boolean parseBoolExpr(String expression) {
        boolean bool = false;
        char c;
        for (int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);
            if (c == '!') {
                return !(parseBoolExpr(expression.substring(i + 1)));
            } else if (c == '&') {
                return parseAnd(expression.substring(i+1));
            } else if (c == '|') {
                return parseOr(expression.substring(i + 1));
            } else if (c == 't'){
                return true;
            } else if (c == 'f'){
                return false;
            }
        }
        return bool;
    }
    
    boolean parseAnd(String s) {
        boolean bool = true;
         char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == ',') {
                continue;
            } else if (c == 'f') {
                return false;
            } else if (c == 't') {
                continue;
            } else if (c == '!') {
                bool = !(parseBoolExpr(s.substring(i + 1)));
                if (bool == false) {
                    return false;
                } else {
                    while (c != ')') {
                        i++;
                        c = s.charAt(i);
                    }
                    continue;
                }
            } else if (c == '&') {
                bool = parseAnd(s.substring(i+1));
                if (bool == false) {
                    return false;
                } else {
                    while (c != ')') {
                        i++;
                        c = s.charAt(i);
                    }
                    continue;
                }
            } else if (c == '|') {
                bool = parseOr(s.substring(i + 1));
                if (bool == false) {
                    return false;
                } else {
                    while (c != ')') {
                        i++;
                        c = s.charAt(i);
                    }
                    continue;
                }
            }
        }
        return true;
    }
    
    boolean parseOr(String s) {
         boolean bool = false;
         char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == ',') {
                continue;
            } else if (c == 'f') {
                continue;
            } else if (c == 't') {
                return true;
            } else if (c == '!') {
                bool = !(parseBoolExpr(s.substring(i + 1)));
                if (bool == true) {
                    return true;
                } else {
                    while (c != ')') {
                        i++;
                        c = s.charAt(i);
                    }
                    continue;
                }
            } else if (c == '&') {
                bool = parseAnd(s.substring(i+1));
                if (bool == true) {
                    return true;
                } else {
                    while (c != ')') {
                        i++;
                        c = s.charAt(i);
                    }
                    continue;
                }
            } else if (c == '|') {
                bool = parseOr(s.substring(i + 1));
                if (bool == true) {
                    return true;
                } else {
                    while (c != ')') {
                        i++;
                        c = s.charAt(i);
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
}

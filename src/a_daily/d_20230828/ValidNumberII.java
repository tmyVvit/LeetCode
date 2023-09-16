package a_daily.d_20230828;

import util.Lists;
import util.Maps;

import java.util.HashMap;
import java.util.Map;

// 使用状态机
public class ValidNumberII {

    private static final Map<State, Map<CharType, State>> transfer = transferMap();

    public static void main(String[] args) {
        ValidNumberII vn = new ValidNumberII();
        System.out.println(vn.isNumber("0"));

    }

    public boolean isNumber(String s) {
        State current = State.START;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            CharType charType = toCharType(ch);
            if (charType == CharType.ILLEGAL) {
                return false;
            }
            current = transfer.get(current).get(charType);
            if (current == null) {
                return false;
            }
        }
        return current.end;
    }

    private static Map<State, Map<CharType, State>> transferMap() {
        Map<State, Map<CharType, State>> map = new HashMap<>();
        map.put(State.START, Maps.of(Lists.of(CharType.SIGN, CharType.DIGIT, CharType.DOT), Lists.of(State.SIGN, State.INTEGER, State.DOT_WITHOUT_LEFT)));
        map.put(State.SIGN, Maps.of(Lists.of(CharType.DIGIT, CharType.DOT), Lists.of(State.INTEGER, State.DOT_WITHOUT_LEFT)));
        map.put(State.INTEGER, Maps.of(Lists.of(CharType.DIGIT, CharType.DOT, CharType.EXP), Lists.of(State.INTEGER, State.DOT, State.EXP)));
        map.put(State.DOT, Maps.of(Lists.of(CharType.DIGIT, CharType.EXP), Lists.of(State.DECIMAL, State.EXP)));
        map.put(State.DOT_WITHOUT_LEFT, Maps.of(Lists.of(CharType.DIGIT), Lists.of(State.DECIMAL)));
        map.put(State.DECIMAL, Maps.of(Lists.of(CharType.DIGIT, CharType.EXP), Lists.of(State.DECIMAL, State.EXP)));
        map.put(State.EXP, Maps.of(Lists.of(CharType.SIGN, CharType.DIGIT), Lists.of(State.EXP_SIGN, State.EXP_INTEGER)));
        map.put(State.EXP_SIGN, Maps.of(Lists.of(CharType.DIGIT), Lists.of(State.EXP_INTEGER)));
        map.put(State.EXP_INTEGER, Maps.of(Lists.of(CharType.DIGIT), Lists.of(State.EXP_INTEGER)));
        return map;
    }

    private static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.DIGIT;
        } else if (ch == '+' || ch == '-') {
            return CharType.SIGN;
        } else if (ch == '.') {
            return CharType.DOT;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.EXP;
        }
        return CharType.ILLEGAL;
    }

    enum State {
        // 初始状态
        START(false),
        // 符号位
        SIGN(false),
        // 整数部分
        INTEGER(true),
        // 小数点
        DOT(true),
        // 左侧无整数的小数点
        DOT_WITHOUT_LEFT(false),
        // 小数部分
        DECIMAL(true),
        // 指数标识
        EXP(false),
        // 指数符号
        EXP_SIGN(false),
        // 指数部分
        EXP_INTEGER(true),
        // 结束状态
        END(true);

        final boolean end;

        State(boolean end) {
            this.end = end;
        }
    }

    enum CharType {
        // 0 - 9
        DIGIT,
        // + -
        SIGN,
        // .
        DOT,
        // e E
        EXP,
        ILLEGAL
    }
}

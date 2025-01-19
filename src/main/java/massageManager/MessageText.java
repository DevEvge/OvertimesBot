package massageManager;


import java.util.Locale;

public class MessageText {
    public static final String ERROR_MESSAGE = "Команда не найдена";
    public static final String START_MESSAGE = "Привет, это телеграм бот для подсчета " +
            "часов переработок, выбери функцию указанную на клавиатуре \uD83D\uDE00";
    public static final String OVERTIMES_MESSAGE = "Введите кол-во часов перерботок в фомате 'ХХ.ХХ'";
    public static final String OVERTIMES_WRITE_ERROR = "Ошибка записи овертаймов, повторите";
    public static final String OVERTIMES_WRITE_SUCCESS = "Овертаймы записанны";
    public static final String GET_OVERTIMES_PERIOD = "Выберете за какой период вы хотите увидеть овертаймы";

    public static String totalHoursForMonth(Double hours) {
        String hoursStr = String.format(Locale.US,"%.2f", hours);
        return "Количество овертаймов за месяц: " + hoursStr;
    }

}

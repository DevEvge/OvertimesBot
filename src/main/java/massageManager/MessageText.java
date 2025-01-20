package massageManager;


import java.util.Locale;

public class MessageText {
    public static final String ERROR_MESSAGE = "\uD83D\uDEAB Команда не найдена. Проверьте ввод.";
        public static final String START_MESSAGE = "\uD83D\uDC4B Привет!\n" +
                "Это телеграм бот для подсчёта часов переработок.\n" +
                "Нажми на одну из кнопок ниже \uD83D\uDE0A";
        public static final String OVERTIMES_MESSAGE = "⏱\uFE0F Напиши, сколько часов переработок у тебя сегодня, в формате \"ХХ.ХХ\".";
    public static final String OVERTIMES_WRITE_ERROR = "❗ Ошибка записи овертаймов. Повторите, пожалуйста.";
    public static final String OVERTIMES_WRITE_SUCCESS = "✅ Овертаймы записаны.";
    public static final String GET_OVERTIMES_PERIOD = "\uD83D\uDCC5 Выберите период, за который хотите увидеть овертаймы.";

    public static String totalHoursForMonth(Double hours) {
        String hoursStr = String.format(Locale.US,"%.2f", hours);
        return "\uD83D\uDCCA Количество овертаймов за месяц: " + hoursStr;
    }

}

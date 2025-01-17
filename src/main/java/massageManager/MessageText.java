    package massageManager;

    import lombok.Getter;

    @Getter
    public class MessageText {
        private final String ERROR_MESSAGE = "Команда не найдена";
        private final String START_MESSAGE = "Привет, это телеграм бот для подсчета " +
                "часов переработок, выбери функцию указанную на клавиатуре \uD83D\uDE00";
        private final String OVERTIMES_MESSAGE = "Введите кол-во часов перерботок в фомате 'ХХ.ХХ'";
        private final String OVERTIMES_WRITE_ERROR = "Ошибка записи овертаймов, повторите";
        private final String OVERTIMES_WRITE_SUCCESS = "Овертаймы записанны";


    }

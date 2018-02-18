package com.github.stagirs.crawler.downloader;



import com.github.stagirs.crawler.model.business.Record;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
public class NdTest extends Nd {
    @Test
    public void recordTest() throws IOException {
        Record record = getRecord("http://nd.ics.org.ru/article-6175/");

        assertEquals(record.getAuthors().size(), 3);
        assertEquals(record.getAuthors().get(0).getSurname(), "Борисов");
        assertEquals(record.getAuthors().get(0).getName(), "А.");
        assertEquals(record.getAuthors().get(1).getSurname(), "Казаков");
        assertEquals(record.getAuthors().get(1).getName(), "А.");
        assertEquals(record.getAuthors().get(2).getSurname(), "Пивоварова");
        assertEquals(record.getAuthors().get(2).getName(), "Е.");
        assertEquals(record.getTitle(), "Регулярная и хаотическая динамика в «резиновой» модели волчка Чаплыгина");
        assertEquals(record.getUrl(), "http://nd.ics.org.ru/upload/iblock/d84/nd1702009.pdf");
        assertEquals(record.getAnnotation(),"В работе исследуется качение динамически несимметричного неуравновешенного шара (волчка Чаплыгина) в поле тяжести по плоскости в предположении отсутствия проскальзывания и прокручивания в точке контакта. Приводится описание странных аттракторов, существующих в системе, а также подробно описывается сценарий рождения одного из них через последовательность бифуркаций удвоения периода. Кроме того, проанализирована динамика системы в абсолютном пространстве и показано, что поведение точки контакта при наличии в системе странных аттракторов существенно зависит от характеристик аттрактора и может иметь как хаотический, так и близкий к квазипериодическому характер.");

        record = getRecord("http://nd.ics.org.ru/article-5614/");

        assertEquals(record.getAuthors().size(), 1);
        assertEquals(record.getAuthors().get(0).getSurname(), "Чернова");
        assertEquals(record.getAuthors().get(0).getName(), "А.");
        assertEquals(record.getTitle(), "Ограничение контактного угла в задаче о капле жидкости на вибрирующей подложке");
        assertEquals(record.getUrl(), "http://nd.ics.org.ru/upload/iblock/9f7/nd1702002.pdf");
        assertEquals(record.getAnnotation(),"Исследуется задача о начальном этапе движения твердого тела в возмущенной жидкости в случае, когда его скорость уменьшается по линейному закону. Особенностью данной задачи является то, что при больших ускорениях возникают области низкого давления вблизи тела и образуются присоединенные каверны. В общем случае зона отрыва представляет собой несвязное множество. Важным аспектом работы является постановка задачи с односторонними ограничениями, на основе которой определяются первоначальные зоны отрыва частиц жидкости, а также формы внутренних свободных границ жидкости на малых временах. Рассматривается пример, в котором начальное возмущение жидкости вызвано безотрывным разгоном кругового цилиндра под свободной поверхностью тяжелой жидкости. Для решения последней задачи применяется специальный приближенный метод (типа альтернирующего метода Шварца), основанный на предположении о том, что свободная поверхность жидкости удалена от плавающего тела на большие расстояния.");


    }
}
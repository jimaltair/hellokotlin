package javacode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Данный метод берёт список строк из входящей коллекции, группирует их по длинам и возвращает список строк с
 * максимальной длиной
 */
public class StepicTask_3_12 {
    public static Collection<String> doSomethingStrangeWithCollection(Collection<String> collection) {

        Map<Integer, List<String>> groupsByLength = Maps.newHashMap();
        // итерируемся по входящей коллекции
        for (String s : collection) {
            // получаем список строк определённой длины
            List<String> strings = groupsByLength.get(s.length());
            // если такого списка нет, создаём его и кладём в map
            if (strings == null) {
                strings = Lists.newArrayList();
                groupsByLength.put(s.length(), strings);
            }
            // если такой список есть, добавляем в него очередную строку
            strings.add(s);
        }

        int maximumSizeOfGroup = 0;
        // итерируемся по спискам строк в map
        for (List<String> group : groupsByLength.values()) {
            // определяем максимальную длину строк, представленную в map
            if (group.size() > maximumSizeOfGroup) {
                maximumSizeOfGroup = group.size();
            }
        }
        // находим список строк с максимальной длиной
        for (List<String> group : groupsByLength.values()) {
            if (group.size() == maximumSizeOfGroup) {
                // возвращаем данный список
                return group;
            }
        }
        return null;
    }
}

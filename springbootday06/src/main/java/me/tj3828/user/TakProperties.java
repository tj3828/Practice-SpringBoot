package me.tj3828.user;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.Duration;
import java.util.List;

/**
 * @author tj3828
 */
/*@Component
@ConfigurationProperties("tj3828")*/
public class TakProperties {

    @NotEmpty
    private String name;
    private List<MyPojo> list;
    private String workFor;
    private String whereToGO;
    private String fooBar;
    private Duration time1;
    private Duration time2;
    private Duration time3;
    @Min(0)
    @Max(100)
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyPojo> getList() {
        return list;
    }

    public void setList(List<MyPojo> list) {
        this.list = list;
    }

    public String getWorkFor() {
        return workFor;
    }

    public void setWorkFor(String workFor) {
        this.workFor = workFor;
    }

    public String getWhereToGO() {
        return whereToGO;
    }

    public void setWhereToGO(String whereToGO) {
        this.whereToGO = whereToGO;
    }

    public String getFooBar() {
        return fooBar;
    }

    public void setFooBar(String fooBar) {
        this.fooBar = fooBar;
    }

    public Duration getTime1() {
        return time1;
    }

    public void setTime1(Duration time1) {
        this.time1 = time1;
    }

    public Duration getTime2() {
        return time2;
    }

    public void setTime2(Duration time2) {
        this.time2 = time2;
    }

    public Duration getTime3() {
        return time3;
    }

    public void setTime3(Duration time3) {
        this.time3 = time3;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

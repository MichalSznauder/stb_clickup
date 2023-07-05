package pl.akademiaqa.dto.request;


import lombok.Data;

@Data
//pojo plain old java object
public class CreateTaskRequestDto {


    private String name;
    private String description;
    private String status;
    private String priority;
    private String parent;
    private String timeEstimate;
    private String assgnees;
    private boolean archived;

/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(String timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public String getAssgnees() {
        return assgnees;
    }

    public void setAssgnees(String assgnees) {
        this.assgnees = assgnees;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }


    @Override
    public String toString() {
        return "CreateTaskRequestDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", parent='" + parent + '\'' +
                ", timeEstimate='" + timeEstimate + '\'' +
                ", assgnees='" + assgnees + '\'' +
                ", archived=" + archived +
                '}';
    }

 */
}

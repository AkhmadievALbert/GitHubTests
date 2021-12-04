package ru.itis.model;

import com.google.common.base.Objects;

/**
 * created: 26-11-2021 - 21:56
 * project: AutoTests2
 *
 * @author Alba
 * @version v0.1
 */
public class RepositoryData {

    private String name;
    private boolean createReadmeFile;

    public RepositoryData(
            String name,
            boolean createReadmeFile
    ) {
        this.name = name;
        this.createReadmeFile = createReadmeFile;
    }

    public RepositoryData() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCreateReadmeFile() {
        return createReadmeFile;
    }

    public void setCreateReadmeFile(boolean createReadmeFile) {
        this.createReadmeFile = createReadmeFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepositoryData repositoryData = (RepositoryData) o;
        return Objects.equal(name, repositoryData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

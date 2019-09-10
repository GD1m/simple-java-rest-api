package ru.gdim.simple_java_rest_api.service.resource_version;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public final class ResourceVersionImpl implements ResourceVersion, DataSerializable {
    private URL url;
    private String eTag;
    private String lastModified;

    @Override
    public void writeData(@NotNull ObjectDataOutput objectDataOutput) throws IOException {
        objectDataOutput.writeObject(url);
        objectDataOutput.writeUTF(eTag);
        objectDataOutput.writeUTF(lastModified);
    }

    @Override
    public void readData(@NotNull ObjectDataInput objectDataInput) throws IOException {
        url = objectDataInput.readObject(URL.class);
        eTag = objectDataInput.readUTF();
        lastModified = objectDataInput.readUTF();
    }
}

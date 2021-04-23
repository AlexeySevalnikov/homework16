import Pet.Pet;
import Pet.Category;
import Pet.TagsItem;
import clients.petstore.PetStore;
import clients.petstore.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonSerialization {
    @Test
    public void testPost() throws IOException {
        Pet myPet = new Pet();
        myPet.setId(25987896);
        myPet.setName("sparky");
        Category category = new Category();
        category.setId(10);
        category.setName("dog");
        myPet.setCategory(category);
        List<String> photo = new ArrayList();
        photo.add("insta-sparky");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list = new ArrayList();
        TagsItem tagsItem = new TagsItem();
        tagsItem.setId(15);
        tagsItem.setName("happy Sparky");
        list.add(tagsItem);
        myPet.setTags(list);
        myPet.setStatus("avaliable");

        PetStore petStore = new PetStoreService().getPetStore();
        petStore.createPet(myPet).execute();
        Pet getPet = petStore.getPet(myPet.getId()).execute().body();
        Assertions.assertEquals(myPet, getPet);
        petStore.delPet(myPet.getId()).execute();
    }

    @Test
    public void testGetOk() throws IOException {
        Pet myPet = new Pet();
        myPet.setId(25987897);
        myPet.setName("Tomas");
        Category category = new Category();
        category.setId(11);
        category.setName("cat");
        myPet.setCategory(category);
        List<String> photo = new ArrayList();
        photo.add("insta-tomas");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list = new ArrayList();
        TagsItem tagsItem = new TagsItem();
        tagsItem.setId(16);
        tagsItem.setName("angry Tomas");
        list.add(tagsItem);
        myPet.setTags(list);
        myPet.setStatus("avaliable");

        PetStore petStore = new PetStoreService().getPetStore();
        petStore.createPet(myPet).execute();
        Pet getPet = petStore.getPet(myPet.getId()).execute().body();
        Assertions.assertEquals(myPet, getPet);
        petStore.delPet(myPet.getId()).execute();
    }

    @Test
    public void testGetError() throws IOException {
        Pet myPet = new Pet();
        myPet.setId(25987898);
        myPet.setName("Barsik");
        Category category = new Category();
        category.setId(12);
        category.setName("cat");
        myPet.setCategory(category);
        List<String> photo = new ArrayList();
        photo.add("insta-barsik");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list = new ArrayList();
        TagsItem tagsItem = new TagsItem();
        tagsItem.setId(17);
        tagsItem.setName("happy Barsik");
        list.add(tagsItem);
        myPet.setTags(list);
        myPet.setStatus("avaliable");

        PetStore petStore = new PetStoreService().getPetStore();
        petStore.createPet(myPet).execute();
        petStore.delPet(myPet.getId()).execute();
        int codeGet = petStore.getPet(myPet.getId()).execute().code();
        Assertions.assertEquals(404, codeGet);
    }

    @Test
    public void testPutOk() throws IOException {
        Pet myPet = new Pet();
        myPet.setId(25987899);
        myPet.setName("Kesha");
        Category category = new Category();
        category.setId(13);
        category.setName("parrot");
        myPet.setCategory(category);
        List<String> photo = new ArrayList();
        photo.add("insta-kesha");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list = new ArrayList();
        TagsItem tagsItem = new TagsItem();
        tagsItem.setId(18);
        tagsItem.setName("funny Kesha");
        list.add(tagsItem);
        myPet.setTags(list);
        myPet.setStatus("avaliable");

        Pet myPet2 = new Pet();
        myPet2.setId(25987899);
        myPet2.setName("Sharik");
        Category category2 = new Category();
        category.setId(13);
        category2.setName("dog");
        myPet2.setCategory(category2);
        List<String> photo2 = new ArrayList();
        photo2.add("insta-sharik");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list2 = new ArrayList();
        TagsItem tagsItem2 = new TagsItem();
        tagsItem2.setId(18);
        tagsItem2.setName("funny Sharik");
        list2.add(tagsItem2);
        myPet2.setStatus("avaliable");

        PetStore petStore = new PetStoreService().getPetStore();
        petStore.createPet(myPet).execute();
        petStore.updatePet(myPet2).execute();
        Pet getPet = petStore.getPet(myPet.getId()).execute().body();
        Assertions.assertEquals(myPet2, getPet);
        petStore.delPet(myPet.getId()).execute();
    }

    @Test
    public void testPutError() throws IOException {
        Pet myPet = new Pet();
        myPet.setId(25987900);
        myPet.setName("Kesha");
        Category category = new Category();
        category.setId(14);
        category.setName("parrot");
        myPet.setCategory(category);
        List<String> photo = new ArrayList();
        photo.add("insta-kesha");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list = new ArrayList();
        TagsItem tagsItem = new TagsItem();
        tagsItem.setId(19);
        tagsItem.setName("funny Kesha");
        list.add(tagsItem);
        myPet.setTags(list);
        myPet.setStatus("avaliable");

        Pet myPet2 = new Pet();
        myPet2.setId(25987900);
        myPet2.setName("Sharik");
        Category category2 = new Category();
        category.setId(14);
        category2.setName("dog");
        myPet2.setCategory(category2);
        List<String> photo2 = new ArrayList();
        photo2.add("insta-sharik");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list2 = new ArrayList();
        TagsItem tagsItem2 = new TagsItem();
        tagsItem2.setId(19);
        tagsItem2.setName("funny Sharik");
        list2.add(tagsItem2);
        myPet2.setStatus("avaliable");

        PetStore petStore = new PetStoreService().getPetStore();
        petStore.createPet(myPet).execute();
        petStore.delPet(myPet.getId()).execute();
        int codePut = petStore.updatePet(myPet2).execute().code();
        Assertions.assertEquals(404, codePut);
    }

    @Test
    public void testDelOk() throws IOException {
        Pet myPet = new Pet();
        myPet.setId(25987901);
        myPet.setName("Gurza");
        Category category = new Category();
        category.setId(15);
        category.setName("cat");
        myPet.setCategory(category);
        List<String> photo = new ArrayList();
        photo.add("insta-gurza");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list = new ArrayList();
        TagsItem tagsItem = new TagsItem();
        tagsItem.setId(20);
        tagsItem.setName("sly Gurza");
        list.add(tagsItem);
        myPet.setTags(list);
        myPet.setStatus("avaliable");

        PetStore petStore = new PetStoreService().getPetStore();
        petStore.createPet(myPet).execute();
        petStore.delPet(myPet.getId()).execute();
        int codeGet = petStore.getPet(myPet.getId()).execute().code();
        Assertions.assertEquals(404, codeGet);
    }

    @Test
    public void testDelError() throws IOException {
        Pet myPet = new Pet();
        myPet.setId(25987902);
        myPet.setName("Anatoly");
        Category category = new Category();
        category.setId(15);
        category.setName("dove");
        myPet.setCategory(category);
        List<String> photo = new ArrayList();
        photo.add("insta-anatoly");
        myPet.setPhotoUrls(photo);
        List<TagsItem> list = new ArrayList();
        TagsItem tagsItem = new TagsItem();
        tagsItem.setId(21);
        tagsItem.setName("just Anatoly");
        list.add(tagsItem);
        myPet.setTags(list);
        myPet.setStatus("avaliable");

        PetStore petStore = new PetStoreService().getPetStore();
        petStore.createPet(myPet).execute();
        petStore.delPet(myPet.getId()).execute();
        int codeDel = petStore.delPet(myPet.getId()).execute().code();
        Assertions.assertEquals(404, codeDel);
    }
}

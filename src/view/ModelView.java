package view;

import business.BrandManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Model;

import javax.swing.*;

public class ModelView extends  Layout{
    private JPanel container;
    private JLabel lbl_header;
    private JLabel lbl_brand;
    private JLabel lbl_model_name;
    private JTextField fld_model_name;
    private JLabel lbl_year;
    private JTextField fld_year;
    private JLabel lbl_type;
    private JComboBox<Model.Type> cmb_type;
    private JComboBox<ComboItem> cmb_brand;
    private JLabel lbl_fuel;
    private JComboBox<Model.Fuel> cmb_fuel;
    private JLabel lbl_gear;
    private JComboBox<Model.Gear> cmb_gear;
    private JButton btn_save;
    private Model model;

    private ModelManager modelManager;

    private BrandManager brandManager;

    public ModelView(Model model) {
        this.model=model;
        this.brandManager = new BrandManager();
        this.modelManager= new ModelManager();
        this.add(container);
        this.guiInitilaze(300,500);

        for (Brand brand: this.brandManager.findAll()){
            this.cmb_brand.addItem( new ComboItem(brand.getId(), brand.getName()));
        }

        this.cmb_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));

        if(this.model.getId() != 0){
            this.fld_year.setText(this.model.getYear());
            this.fld_model_name.setText(this.model.getName());
            this.cmb_fuel.getModel().setSelectedItem(this.model.getFuel());
            this.cmb_type.getModel().setSelectedItem(this.model.getType());
            this.cmb_gear.getModel().setSelectedItem(this.model.getGear());
            ComboItem defaultBrand = new ComboItem(this.model.getBrand().getId(),this.model.getBrand().getName());
            this.cmb_brand.getModel().setSelectedItem(defaultBrand);
        }

        this.btn_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_model_name,this.fld_year})){
                Helper.showMsg("fill");
            }else{
                boolean result=false;
                ComboItem selectedBrand = (ComboItem) cmb_brand.getSelectedItem();
                this.model.setYear(fld_year.getText());
                this.model.setName(fld_model_name.getText());
                this.model.setBrand_id(selectedBrand.getKey());
                this.model.setType((Model.Type) cmb_type.getSelectedItem());
                this.model.setFuel((Model.Fuel) cmb_fuel.getSelectedItem());
                this.model.setGear((Model.Gear) cmb_gear.getSelectedItem());
                if (this.model.getId() !=0){
                    result= this.modelManager.update(this.model);

                }else {
                    result = this.modelManager.save(this.model);
                }
                if(result){
                    Helper.showMsg("done");
                    dispose();
                }else {
                    Helper.showMsg("error");
                }
            }
        });

    }


}

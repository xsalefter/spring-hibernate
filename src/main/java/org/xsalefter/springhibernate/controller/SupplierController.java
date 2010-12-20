package org.xsalefter.springhibernate.controller;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xsalefter.springhibernate.model.Supplier;
import org.xsalefter.springhibernate.service.SupplierService;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Controller
public class SupplierController {

    @Inject private SupplierService supplierService;

    @RequestMapping(value="/supplier/index.html")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("suppliers", this.supplierService.selectAll());
        mav.setViewName("supplier/index");
        return mav;
    }


    @RequestMapping(value="/supplier/form.html")
    public String form(@RequestParam(required=false) Long supplierId,
        @ModelAttribute Supplier supplier, ModelMap map) {

        if (supplierId != null)
            supplier = this.supplierService.getByID(supplierId);

        map.addAttribute("supplierId", supplierId);
        map.addAttribute("supplier", supplier);
        
        return "/supplier/form";
    }
    

    @RequestMapping(value="/supplier/save-action.html")
    public String save(@ModelAttribute @Valid Supplier supplier, BindingResult bindingResult, ModelMap map) {
        boolean persisted = supplier.getId() == null;
        if (!bindingResult.hasErrors()) {
            Supplier saved = this.supplierService.saveOrUpdate(supplier);
            return "redirect:/supplier/display.html?supplierId=" + saved.getId() + "&action=" + persisted;
        } else {
            return "/supplier/form";
        }
    }


    @RequestMapping(value="/supplier/display.html", params={"supplierId", "action"})
    public String display(@RequestParam Long supplierId, @RequestParam boolean action, ModelMap map) {
        final String msg = "Supplier data has been " + (action ? "created." : "updated.");
        map.addAttribute("actionMessage", msg);
        map.addAttribute("supplier", this.supplierService.getByID(supplierId));
        return "/supplier/display";
    }
}

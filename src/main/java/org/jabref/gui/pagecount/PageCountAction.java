package org.jabref.gui.actions;

import org.jabref.gui.JabRefFrame;
import org.jabref.logic.bibtex.comparator.PageCountComparator;
import org.jabref.model.entry.BibEntry;

import java.util.List;
import java.util.stream.Collectors;

public class PageCountAction extends SimpleCommand {

    private final JabRefFrame frame;

    public PageCountAction(JabRefFrame frame) {
        this.frame = frame;
    }

    @Override
    public void execute() {
        List<BibEntry> selectedEntries = frame.getCurrentLibraryTab().getSelectedEntries();
        List<String> pageCounts = selectedEntries.stream()
                .map(entry -> entry.getField("pages"))
                .map(PageCountComparator::calculatePageCount)
                .collect(Collectors.toList());

        // Display page counts (you can modify this part to suit your needs)
        pageCounts.forEach(System.out::println);
    }
}
